import { BrowserRouter, Routes, Route } from "react-router-dom"
import "/public/css/index.css"
import HomeLayout from "./components/Layout/HomeLayout"
import HomePage from "./pages/HomePage"
import ImagePage from "./features/Images/ImagePage"
import NukeCodePage from "./features/SourceCode/NukeCodePage"
function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<HomeLayout />}>
          <Route index element={<HomePage />} />
          <Route path="image" element={<ImagePage />} />
          <Route path="sauce" element={<NukeCodePage />} />
        </Route>
      </Routes>
    </BrowserRouter>
  )
}

export default App
