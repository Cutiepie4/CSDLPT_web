import axios from 'axios';
import React, { useEffect, useState } from 'react';

function AddFlight(props) {

    const [flight, setFlight] = useState({});

    const [listPlane, setListPlane] = useState([]);

    const [listAirport, setListAirport] = useState([]);

    useEffect(() => {
        axios.get('/api/dsmb').then(res => setListPlane(res.data));
        axios.get('/api/dssb').then(res => setListAirport(res.data));
    }, [])

    const addFlight = () => {
        console.log(flight)
        axios.post('/api/dscb/new', flight).then(res => { });
    }

    return (
        <div className='container form-group'>
            <h1>Thêm chuyến bay</h1>
            <div><input type="text" placeholder='Mã chuyến bay' onChange={e => setFlight({ ...flight, maCB: e.target.value })} /></div>
            <div>
                <select onChange={(e) => { setFlight({ ...flight, maMB: e.target.value }) }}>
                    <option disabled selected>Chọn máy bay</option>
                    {listPlane.map((plane, index) => (
                        <option key={index} value={plane.maMB}>
                            {plane.tenMB}
                        </option>
                    ))}
                </select>
            </div>
            <div>
                <select onChange={(e) => { setFlight({ ...flight, sanBayXuatPhat: e.target.value }) }}>
                    <option disabled selected>Chọn sân bay</option>
                    {listAirport.map((airport, index) => (
                        <option key={index} value={airport.maSB}>
                            {airport.tenSB}
                        </option>
                    ))}
                </select>
            </div>
            <div>
                <select onChange={(e) => { setFlight({ ...flight, sanBayDich: e.target.value }) }}>
                    <option disabled selected>Chọn sân bay</option>
                    {listAirport.map((airport, index) => (
                        <option key={index} value={airport.maSB}>
                            {airport.tenSB}
                        </option>
                    ))}
                </select>
            </div>
            <div><input type="datetime-local" onChange={(e) => { setFlight({ ...flight, thoiGianBatDau: e.target.value }) }} /></div>
            <div><input type="datetime-local" onChange={(e) => { setFlight({ ...flight, thoiGianKetThuc: e.target.value }) }} /></div>
            <div><input type="number" placeholder='Số lượng số ngồi còn lại' onChange={(e) => { setFlight({ ...flight, slChoNgoiConLai: e.target.value }) }} /></div>
            <div><button onClick={addFlight}>Thêm</button></div>
        </div>
    );
}

export default AddFlight;