import axios from 'axios';

const EMPLOYEE_BASE_REST_API_URL="http://localhost:8080/api/v1/employee";

class EmpployeeServices{

    getAllEmployees(){
        return axios.get(`${EMPLOYEE_BASE_REST_API_URL}/allEmployee`);
    }

    createEmployee(employee){
        return axios.post(`${EMPLOYEE_BASE_REST_API_URL}/employeeDetails`, employee);
    }

    getEmployeeById(employeeId){
        return axios.get(EMPLOYEE_BASE_REST_API_URL + '/' + employeeId)   
     }

    updateEmployee(employee, employeeId){
        return axios.put(EMPLOYEE_BASE_REST_API_URL + '/' + employeeId, employee);
    }

    deleteEmployee(employeeId){
        return axios.delete(EMPLOYEE_BASE_REST_API_URL + '/' + employeeId);     
    }
}

export default new EmpployeeServices();