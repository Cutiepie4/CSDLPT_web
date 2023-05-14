import { Routes, Route } from "react-router-dom";
import AddFlight from "./components/AddFlight";
import Nav from "./components/Nav";
import AddEmployee from "./components/AddEmployee";
import Thongke from "./components/Thongke";

function App() {
  return (
    <div>
      <Routes>
        <Route path="/" element={<Nav />} >
          <Route element={<AddFlight />} path='/chuyenbay' />
          <Route element={<AddEmployee />} path="/nhanvien" />
          <Route element={<Thongke />} path="/thongke" />
        </Route>
      </Routes>
    </div>
  );
}

export default App;
