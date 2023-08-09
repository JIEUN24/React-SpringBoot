import React from "react";
import styled from "styled-components";

const DetailPostPage = () => {
  return (
    <DetailPostWrap>
      <p>게시글 상세페이지</p>
    </DetailPostWrap>
  );
};

const DetailPostWrap = styled.div`
  max-width: 800px;
  width: 90%;
  margin: 80px auto;
`;

export default DetailPostPage;
