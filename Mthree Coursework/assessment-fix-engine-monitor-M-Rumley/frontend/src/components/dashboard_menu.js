import React from "react"
import { Link } from "react-router-dom"
 
function DashboardMenu (){
    return (
        <div id="dashboard_menu" className="App-menu">
            <ul>
                <li><Link to='/dashboard/instruments'>
                    Instrument Table
                </Link></li>
                <li><Link to='/dashboard/ric'>
                    RIC Table
                </Link></li>
                <li><Link to='/dashboard/product'>
                    Product Table
                </Link></li>
                <li><Link to='/dashboard/orders'>
                    Orders Table
                </Link></li>
                <li><Link to='/dashboard/mic'>
                    MIC Table
                </Link></li>
                <li><Link to='/dashboard/fix'>
                    Fix Table
                </Link></li>
                <li><Link to='/dashboard/contract'>
                    Contract Table
                </Link></li>
            </ul>
        </div>
    )
}
 
export default DashboardMenu