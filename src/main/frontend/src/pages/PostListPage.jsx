import React, { useEffect, useState } from 'react';
import axios from 'axios';

const PostListPage = () => {
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

  const addContent = () => {
    axios
      .post('/board/add', {
        title: post?.title,
        content: post?.content,
        userName: post?.userName,
      })
      .then((res) => {
        console.log(res);
      })
      .catch((err) => {
        console.log(err);
      });
  };

  const deleteContent = (id) => {
    axios
      .delete(`/board/delete/${id}`)
      .then((res) => {
        console.log(res);
      })
      .catch((err) => {
        console.log(err);
      });
  };

  useEffect(() => {
    axios
      .get('/board/list')
      .then((res) => {
        console.log(res);
        setList(res.data);
      })
      .catch((err) => {
        console.log(err);
      });
  }, []);

  return (
    <div>
      <p>게시글 목록 페이지</p>
      {list?.map((ele, idx) => {
        return (
          <div key={idx}>
            <span>{ele.title}</span>
            <button
              onClick={() => {
                deleteContent(ele.id);
              }}
            >
              삭제
            </button>
          </div>
        );
      })}
      <div>
        <div>
          제목:{' '}
          <input
            name='title'
            type='text'
            onChange={(e) => {
              onChangeHandler(e);
            }}
          />
        </div>
        <div>
          내용:{' '}
          <input
            name='content'
            type='text'
            onChange={(e) => {
              onChangeHandler(e);
            }}
          />
        </div>
        <div>
          작성자:{' '}
          <input
            name='userName'
            type='text'
            onChange={(e) => {
              onChangeHandler(e);
            }}
          />
        </div>
        <button onClick={addContent}>저장</button>
      </div>
    </div>
  );
};

export default PostListPage;
