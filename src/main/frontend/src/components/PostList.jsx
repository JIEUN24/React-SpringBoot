import React, { useState } from 'react';
import { styled } from 'styled-components';
import axios from 'axios';

const PostList = (props) => {
  const { id, list, deleteContent } = props;
  const [click, setClick] = useState(false);

  return (
    <>
      <ListTitle
        onClick={() => {
          setClick(!click);
        }}
      >
        <div className='id'>{id + 1}</div>
        <div className='title'>{list?.title}</div>
        <div className='name'>{list?.userName}</div>
        <div className='date'>{list?.createAt?.split(' ')[0]}</div>
      </ListTitle>
      {click && (
        <ListContent>
          <div className='content'>{list.content}</div>
          <div className='edit'>
            <span>수정</span>
            <span
              onClick={() => {
                deleteContent(list.id);
              }}
            >
              삭제
            </span>
          </div>
        </ListContent>
      )}
    </>
  );
};

const ListTitle = styled.div`
  width: 100%;
  height: 60px;
  border-bottom: 1px solid #d2dcff;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
  font-size: 12px;

  &:hover {
    cursor: pointer;
  }

  .id {
    width: 6%;
    display: flex;
    justify-content: center;
  }
  .title {
    width: 65%;
    display: flex;
    justify-content: flex-start;
  }
  .name {
    width: 10%;
    display: flex;
    justify-content: flex-end;
  }
  .date {
    width: 15%;
    display: flex;
    justify-content: center;
  }
`;

const ListContent = styled.div`
  width: 100%;
  height: 60px;
  background-color: #ffffff;
  display: flex;
  flex-direction: row;
  justify-content: space-evenly;
  align-items: center;

  font-size: 12px;

  .content {
    width: 70%;
    padding: 10px;
  }

  .edit {
    display: flex;
    flex-direction: row;

    span {
      display: block;
      padding: 5px;
      margin: 0 5px;
      color: #3c52bb;

      &:hover {
        cursor: pointer;
        background-color: #e5f0fb;
        border: none;
        border-radius: 5px;
      }
    }
  }
`;

export default PostList;
