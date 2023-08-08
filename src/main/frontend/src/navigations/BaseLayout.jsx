import React from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import PostListPage from '../pages/PostListPage';
import CreatePostPage from '../pages/CreatePostPage';
import DetailPostPage from '../pages/DetailPostPage';

const BaseLayout = () => {
  return (
    <BrowserRouter>
      <Routes>
        <Route path='/' exact element={<PostListPage />} />
        <Route path='/create-post' exact element={<CreatePostPage />} />
        <Route path='/create-post/:id' exact element={<CreatePostPage />} />
        <Route path='/post/:id' exact element={<DetailPostPage />} />
      </Routes>
    </BrowserRouter>
  );
};

export default BaseLayout;
