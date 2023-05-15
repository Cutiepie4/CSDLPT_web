import axios from 'axios';
import React, { useEffect, useState } from 'react';

function AddEmployee(props) {

    const [employee, setEmployee] = useState({});

    const [branch, setBranch] = useState([]);

    const [listE, setListE] = useState([]);

    const [msg, setMsg] = useState('');

    useEffect(() => {
        axios.get('/api/dscn').then(res => setBranch(res.data));
        axios.get('/api/dsnv').then(res => setListE(res.data));
    }, [])

    const addE = () => {
        if (listE.some(item => item.maNV === employee.maNV)) setMsg('Id da ton tai.');
        else {
            axios.post('/api/dsnv/new', employee);
            setMsg('Them thanh cong');
        }
    }

    return (
        <div className='container'>
            <h1>Thêm nhân viên</h1>
            <div>
                <input type="text" placeholder='Mã nhân viên' onChange={e => setEmployee({ ...employee, maNV: e.target.value })} required />
            </div>
            <div>
                <input type="text" placeholder='Tên nhân viên' onChange={e => setEmployee({ ...employee, tenNV: e.target.value })} required />
            </div>
            <div>
                <select onChange={(e) => { setEmployee({ ...employee, maCN: e.target.value }) }} required>
                    <option disabled selected>Chọn chi nhánh</option>
                    {branch.map((branch, index) => (
                        <option key={index} value={branch.maCN}>
                            {branch.diaChi}
                        </option>
                    ))}
                </select>
            </div>
            <div>
                <input type="date" placeholder='Ngày sinh' onChange={e => setEmployee({ ...employee, ngaySinh: e.target.value })} required />
            </div>
            <div>
                <input type="number" placeholder='Số điện thoại' onChange={e => setEmployee({ ...employee, sdt: e.target.value })} required />
            </div>
            <div>
                <input type="text" placeholder='Chức Vụ' onChange={e => setEmployee({ ...employee, chucVu: e.target.value })} required />
            </div>

            <div>
                <button onClick={addE}>Thêm</button>
            </div>

            <div><h3>{msg}</h3></div>
        </div>
    );
}

export default AddEmployee;