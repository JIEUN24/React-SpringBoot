import React from 'react';
import { styled } from 'styled-components';

const CreatePostPage = () => {
  return (
    <CreatePostWrap>
      <p>게시글 작성 페이지</p>
    </CreatePostWrap>
  );
};

const CreatePostWrap = styled.div`
  max-width: 800px;
  width: 90%;
  margin: 80px auto;
`;

export default CreatePostPage;
