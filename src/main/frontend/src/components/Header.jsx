import React from 'react';
import { styled } from 'styled-components';

const Header = () => {
  return (
    <HeaderWrap>
      <div>header</div>
    </HeaderWrap>
  );
};

const HeaderWrap = styled.div`
  width: 100%;
  height: 50px;
  box-shadow: 1px 1px 1px 1px #d2dcff;
  position: fixed;
  top: 0;

  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;

  div {
    max-width: 800px;
    width: 90%;
  }
`;

export default Header;
