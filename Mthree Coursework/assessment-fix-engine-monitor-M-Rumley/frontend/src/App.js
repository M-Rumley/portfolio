import React, {Component} from 'react';
import { Switch, Route } from "react-router-dom"
//import logo from './logo.svg';
import './App.css';
import Counter from './pages/Counter';
import FormData from "./pages/FormData"
import NavBar from "./components/nav_bar"
import DashboardPage from "./pages/DashboardPage"

class App extends Component {
  render() {
    return (
      <div className="App">
        <NavBar />
        <main>
          <Switch>
            <Route path='/counter' component={Counter} />
            <Route path='/formdata' component={FormData} />
            <Route path='/dashboard' component={DashboardPage}/>
          </Switch>
        </main>
      </div>
    )
  }
}

export default App;
