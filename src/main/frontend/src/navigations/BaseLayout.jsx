import React from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import PostListPage from '../pages/PostListPage';
import CreatePostPage from '../pages/CreatePostPage';

const BaseLayout = () => {
  return (
    <BrowserRouter>
      <Routes>
        <Route path='/' exact element={<PostListPage />} />
        <Route path='/create-post' exact element={<CreatePostPage />} />
        <Route path='/create-post/:id' exact element={<CreatePostPage />} />
      </Routes>
    </BrowserRouter>
  );
};

export default BaseLayout;
