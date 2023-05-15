import axios from 'axios';
import React, { useEffect, useState } from 'react';

function Thongke(props) {

    const [thongKe, setThongKe] = useState([]);

    useEffect(() => {
        axios.get('/api/thongke').then(res => setThongKe(res.data));
    }, []);

    return (
        <div className='container'>
            <h1>Thong ke</h1>
            <div>
                <table className="table table-striped table-bordered">
                    <thead className="table-dark">
                        <tr>
                            <th>Tên Chi Nhánh</th>
                            <th>Địa chỉ chi nhánh</th>
                            <th>Tổng số vé</th>
                            <th>Tổng tiền vé (vnd)</th>
                        </tr>
                    </thead>

                    <tbody>
                        {thongKe.map((item, index) => (
                            <tr key={index}>
                                <td>{item.tenCN}</td>
                                <td>{item.diaChi}</td>
                                <td>{item.tongSoVe}</td>
                                <td>{item.tongTienBanVe}</td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
        </div>
    );
}

export default Thongke; <h1>thong ke</h1>