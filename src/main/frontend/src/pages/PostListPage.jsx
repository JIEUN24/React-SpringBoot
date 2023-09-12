import React, {useEffect, useState} from "react";
import {useNavigate} from "react-router-dom";
import PostList from "../components/PostList";
import PaginationSize from "../components/PaginationSize";
import axios from "axios";
import styled from "styled-components";
import Swal from "sweetalert2";

const PostListPage = () => {
    const navigate = useNavigate();
    const [list, setList] = useState([]);
    const [totalPages, setTotalPages] = useState(0);
    const [page, setPage] = useState(1);

    const getList = (page) => {
        axios
            .get(`/posts?page=${page}&size=5`)
            .then((res) => {
                setTotalPages(res.data.totalPages);
                setList(res.data.posts);
            })
            .catch((err) => {
                console.log(err);
            });
    };

    const deleteContent = (id) => {
        Swal.fire({
            title: "게시물을 삭제하시겠습니까?",
            text: "삭제한 게시물은 다시 되돌릴 수 없습니다.",
            icon: "warning",
            showCancelButton: true,
            confirmButtonColor: "#3c52bb",
            cancelButtonColor: "#d33",
            confirmButtonText: "삭제",
            cancelButtonText: "취소",
        }).then((result) => {
            if (result.isConfirmed) {
                axios
                    .delete(`/posts/${id}`)
                    .then((res) => {
                        getList(page);
                        Swal.fire("삭제완료", res.data.message, res.data.status);
                    })
                    .catch((err) => {
                        console.log(err);
                    });
            }
        });
    };

    useEffect(() => {
        getList(page);
    }, [page]);

    return (
        <ListWrap>
            <ListHeader>
                <h3>리뷰 게시판</h3>
                <button
                    onClick={() => {
                        navigate("/create-post");
                    }}
                >
                    작성
                </button>
            </ListHeader>
            {list &&
                list?.map((item, idx) => {
                    return <PostList key={idx} list={item} id={idx} deleteContent={deleteContent}/>;
                })}
            <PaginationSize totalPages={totalPages} setPage={setPage}/>
        </ListWrap>
    );
};

const ListWrap = styled.div`
  max-width: 800px;
  width: 90%;
  margin: 80px auto;
`;

const ListHeader = styled.div`
  width: 100%;
  height: 50px;
  margin-top: 10px;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
  border-bottom: 2px solid #3c52bb;

  h3 {
    color: #3c52bb;
  }

  button {
    width: 60px;
    height: 25px;
    background: #3c52bb;
    border: none;
    border-radius: 5px;
    color: #ffffff;

    &:hover {
      cursor: pointer;
      transform: scale(0.95);
    }
  }
`;

export default PostListPage;
