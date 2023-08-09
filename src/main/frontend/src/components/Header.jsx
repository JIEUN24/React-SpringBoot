import React from "react";
import { useNavigate } from "react-router-dom";
import { styled } from "styled-components";

const Header = () => {
  const navigate = useNavigate();
  return (
    <HeaderWrap>
      <div>
        <h2
          onClick={() => {
            navigate("/");
          }}
        >
          Home
        </h2>
      </div>
    </HeaderWrap>
  );
};

const HeaderWrap = styled.div`
  width: 100%;
  height: 50px;
  box-shadow: 1px 1px 1px 1px #d2dcff;
  background-color: #f1f4ff;
  position: fixed;
  top: 0;

  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;

  div {
    max-width: 800px;
    width: 90%;

    h2 {
      cursor: pointer;
    }
  }
`;

export default Header;
