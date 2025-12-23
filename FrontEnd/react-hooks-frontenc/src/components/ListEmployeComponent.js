import React, {useEffect, useState } from "react";
import EmployeeServices from "../services/EmployeeServices";
import { Link } from "react-router-dom";


const ListEmployeComponent = () => {
    const[employee, setEmployees] =useState([]);

    useEffect(() => {

      EmployeeServices.getAllEmployees().then((response) => {
        setEmployees(response.data);
        console.log(response.data);
      }).catch(error => {
        console.log(error);
      });
    }, []);

    const getAllEmployees = () => {EmployeeServices.getAllEmployees().then((response) => {
        setEmployees(response.data);
        console.log(response.data);
      }).catch(error => {
        console.log(error);
      });
    }
    const deleteEmployee = (employeeId) => {
      EmployeeServices.deleteEmployee(employeeId).then( (response) => {
        console.log("Employee deleted successfully", response.data);
        getAllEmployees();
      }).catch(error => {
        console.log(error);
      });
    };

  return (
    <div className="container">
      <h2 className="text-center">List Employees </h2>
      <Link to="/add-employee" className="btn btn-primary mb-2"> Add Employee</Link>
      <table className="table table-bordered table-striped">
        <thead>
          <tr>
            <th>Employee ID</th>
            <th>Employee First Name</th>
            <th>Employee Last Name</th>
            <th>Employee Email</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
            {
                employee.map(
                    employee=> 
                        <tr key={employee.id}>
                            <td>{employee.id}</td>
                            <td>{employee.firstName}</td>
                            <td>{employee.lastName}</td>
                            <td>{employee.emailId}</td>
                            <td>
                              <Link className="btn btn-info" to= {`/employees/edit-employee/${employee.id}`}> Update </Link>
                              <button className="btn btn-danger" onClick={() => deleteEmployee(employee.id)} 
                                style={{marginLeft:"10px"}}> Delete </button>
                            </td>
                        </tr>
                )
            }
        </tbody>
      </table>
    </div>
  )
}

export default ListEmployeComponent

