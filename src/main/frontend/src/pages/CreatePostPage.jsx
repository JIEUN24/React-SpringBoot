import React, {useEffect, useState} from "react";
import {useNavigate, useParams} from "react-router-dom";
import styled from "styled-components";
import axios from "axios";
import Swal from "sweetalert2";

const CreatePostPage = () => {
    const navigate = useNavigate();
    const params = useParams();
    const postId = params?.id;
    const [post, setPost] = useState({
        title: "",
        content: "",
        userName: "",
    });
    const [detail, setDetail] = useState({});

    const onChangeHandler = (e) => {
        const {name, value} = e.target;
        setPost({...post, [name]: value});
    };

    const addContent = () => {
        axios
            .post("/posts", {
                title: post?.title,
                content: post?.content,
                userName: post?.userName,
            })
            .then((res) => {
                Swal.fire({
                    position: "top-center",
                    icon: "success",
                    title: "등록이 완료되었습니다",
                    showConfirmButton: false,
                    timer: 1000,
                });
                navigate("/");
            })
            .catch((err) => {
                console.log(err);
            });
    };

    const upDateContent = (id) => {
        axios
            .put("/posts", {
                id: id,
                title: post?.title,
                content: post?.content,
                userName: post?.userName,
            })
            .then((res) => {
                Swal.fire({
                    position: "top-center",
                    icon: "success",
                    title: "수정이 완료되었습니다",
                    showConfirmButton: false,
                    timer: 1000,
                });
                navigate("/");
            })
            .catch((err) => {
                console.log(err);
            });
    };

    useEffect(() => {
        if (postId) {
            axios
                .get(`/posts/${postId}`)
                .then((res) => {
                    const data = res.data[0]
                    setPost({
                        title: data.title,
                        content: data.content,
                        userName: data.userName,
                    });
                    setDetail(res.data[0]);
                })
                .catch((err) => {
                    console.log(err);
                });
        }
    }, []);

    return (
        <CreatePostWrap>
            <CreateHeader>
                <h3>{postId ? "리뷰 수정" : "리뷰 작성"}</h3>
                <div>
                    <button
                        onClick={() => {
                            Swal.fire({
                                title: "리뷰 작성을 취소하시겠습니까?",
                                text: "기존에 작성하던 글이 유지되지 않습니다.",
                                icon: "warning",
                                showCancelButton: true,
                                confirmButtonColor: "#3c52bb",
                                cancelButtonColor: "#d33",
                                confirmButtonText: "확인",
                                cancelButtonText: "취소",
                            }).then((result) => {
                                if (result.isConfirmed) {
                                    navigate("/");
                                } else {
                                    return;
                                }
                            });
                        }}
                    >
                        취소
                    </button>
                    <button
                        onClick={() => {
                            if (postId) {
                                upDateContent(postId);
                            } else {
                                addContent();
                            }
                        }}
                    >
                        {postId ? "저장" : "등록"}
                    </button>
                </div>
            </CreateHeader>
            <CreateBody>
                <div className='contentBox'>
                    <div>작성자</div>
                    <input
                        name='userName'
                        type='text'
                        defaultValue={postId ? detail.userName : post.userName}
                        onChange={(e) => {
                            onChangeHandler(e);
                        }}
                    />
                </div>
                <div className='contentBox'>
                    <div>제목</div>
                    <input
                        name='title'
                        type='text'
                        defaultValue={postId ? detail.title : post.title}
                        onChange={(e) => {
                            onChangeHandler(e);
                        }}
                    />
                </div>
                <div className='contentBox'>
                    <div>내용</div>
                    <textarea
                        name='content'
                        type='text'
                        defaultValue={postId ? detail.content : post.content}
                        onChange={(e) => {
                            onChangeHandler(e);
                        }}
                    />
                </div>
            </CreateBody>
        </CreatePostWrap>
    );
};

const CreatePostWrap = styled.div`
  max-width: 800px;
  width: 90%;
  margin: 80px auto;
`;

const CreateHeader = styled.div`
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
    margin-left: 10px;

    &:hover {
      cursor: pointer;
      transform: scale(0.95);
    }
  }
`;

const CreateBody = styled.div`
  width: 100%;
  background-color: white;
  font-size: 14px;
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 10px 0px 20px 0px;

  .contentBox {
    width: 95%;
    min-height: 50px;
    display: flex;
    flex-direction: row;
    justify-content: center;
    align-items: center;

    div {
      width: 10%;
      height: 100%;
      display: flex;
      justify-content: flex-start;

      span {
        display: block;
      }
    }

    input,
    textarea {
      display: block;
      width: 90%;
      height: 20px;
      border: 1px solid #d2dcff;
      border-radius: 5px;
    }

    textarea {
      height: 300px;
    }
  }
`;

export default CreatePostPage;
