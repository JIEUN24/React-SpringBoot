import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import PostListPage from "../pages/PostListPage";
import CreatePostPage from "../pages/CreatePostPage";
import DetailPostPage from "../pages/DetailPostPage";
import Header from "../components/Header";

const BaseLayout = () => {
  return (
    <BrowserRouter>
      <Header />
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
