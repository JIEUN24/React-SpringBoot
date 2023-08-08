import React, { useEffect, useState } from 'react';
import axios from 'axios';
import styled from 'styled-components';
import { useNavigate } from 'react-router-dom';
import PostList from '../components/PostList';

const PostListPage = () => {
  const navigate = useNavigate();
  const [list, setList] = useState([]);
  const [post, setPost] = useState({
    title: '',
    content: '',
    userName: '',
  });

  const onChangeHandler = (e) => {
    const { name, value } = e.target;
    setPost({ ...post, [name]: value });

    console.log(post);
  };

  const getList = () => {
    axios
      .get('/board/list')
      .then((res) => {
        console.log(res);
        setList(res.data);
      })
      .catch((err) => {
        console.log(err);
      });
  };

  const addContent = () => {
    axios
      .post('/board/add', {
        title: post?.title,
        content: post?.content,
        userName: post?.userName,
      })
      .then((res) => {
        console.log(res);
        setList([...list, post]);
      })
      .catch((err) => {
        console.log(err);
      });
  };

  const upDateContent = (id) => {
    axios
      .put('/board/update', {
        id: id,
        title: post?.title,
        content: post?.content,
        userName: post?.userName,
      })
      .then((res) => {
        console.log(res);
        getList();
      })
      .catch((err) => {
        console.log(err);
      });
  };

  const deleteContent = (id) => {
    axios
      .delete(`/board/delete/${id}`)
      .then((res) => {
        setList((ele) => {
          return ele.filter((list) => list.id !== id);
        });
        console.log(res);
      })
      .catch((err) => {
        console.log(err);
      });
  };

  useEffect(() => {
    getList();
  }, []);

  return (
    <ListWrap>
      <ListHeader>
        <h3>리뷰 게시판</h3>
        <button
          onClick={() => {
            navigate('/create-post');
          }}
        >
          작성
        </button>
      </ListHeader>
      {list &&
        list?.map((item, idx) => {
          return <PostList key={idx} list={item} id={idx} deleteContent={deleteContent} />;
        })}
      {list?.length === 0 && <div>게시물 없음</div>}
      <input
        name='title'
        type='text'
        onChange={(e) => {
          onChangeHandler(e);
        }}
      />
      <input
        name='content'
        type='text'
        onChange={(e) => {
          onChangeHandler(e);
        }}
      />
      <input
        name='userName'
        type='text'
        onChange={(e) => {
          onChangeHandler(e);
        }}
      />
      <button onClick={addContent}>add</button>
      <button
        onClick={() => {
          upDateContent(14);
        }}
      >
        update
      </button>
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
