import './App.css';
import ListEmployeComponent from './components/ListEmployeComponent';
import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FooterComponent';
import {BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import AddEmployeeComplonent from './components/AddEmployeeComplonent';

function App() {
  return (
    <div>
      <Router>
      <HeaderComponent />
      <div className='container'>
        <Routes>
        <Route path = "/" element={<ListEmployeComponent />}></Route>
        <Route path = "/employees" element={<ListEmployeComponent />}></Route>
        <Route path = "/add-employee" element={<AddEmployeeComplonent />}></Route>
        <Route path = "/employees/edit-employee/:id" element={<AddEmployeeComplonent />}></Route>
        </Routes>
      </div>
      <FooterComponent />
      </Router>
    </div>
  );
}

export default App;
