import React, {Component} from "react"
import { Switch, Route } from "react-router-dom"
import DashboardMenu from "../components/dashboard_menu"
import Orders from "./OrdersPage"
import Instruments from "./InstrumentsPage"
class DashboardPage extends Component {
    render(){
        return (
            <div id="dashboard_page" className="App-page">
                <DashboardMenu />
                <Switch>
                    <Route exact path="/dashboard"
                        component={() => "Dashboard Content"} />
                    <Route path="/dashboard/instruments" component={Instruments}/>
                    <Route path="/dashboard/orders" component = {Orders}/>
                </Switch>
            </div>
        )
    }
   
}

export default DashboardPage