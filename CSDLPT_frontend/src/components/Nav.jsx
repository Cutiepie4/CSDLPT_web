import React from 'react';
import { NavLink, Outlet } from 'react-router-dom';

function Nav(props) {
    return (
        <div>
            <nav className="navbar navbar-expand-lg navbar-light">
                <div className="collapse navbar-collapse">
                    <div className="navbar-nav">
                        <NavLink className="nav-link navbar-nav" to="/chuyenbay">Chuyến bay</NavLink>
                        <NavLink className="nav-link navbar-nav" to="/nhanvien">Nhân Viên</NavLink>
                        <NavLink className="nav-link navbar-nav" to="/thongke">Thống kê</NavLink>
                    </div>
                </div>
            </nav>

            <Outlet />
        </div>
    );
}

export default Nav;