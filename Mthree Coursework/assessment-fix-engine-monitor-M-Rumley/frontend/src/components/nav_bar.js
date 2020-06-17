import React from "react"
import { NavLink } from 'react-router-dom'
import "../styles/nav_bar.css"
 
function NavBar() {
    return (
        <div className="nav_list">
            <ul>
                <li><NavLink to='/'>Home</NavLink></li>
                <li><NavLink to='/counter'>Counter</NavLink></li>
                <li><NavLink to='/formdata'>Form Data</NavLink></li>
                <li><NavLink to='/dashboard'>Dashboard</NavLink></li>
            </ul>
        </div>
    );
}
 
export default NavBar