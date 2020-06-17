import React, { Component }from 'react';

class Counter extends Component{
    constructor(){
        super()
        this.state = {
            counter:0
        }
        this.addOneClick = this.addOneClick.bind(this)
        this.doubleClick = this.doubleClick.bind(this)

    }
    addOneClick(){
        this.setState(prevState =>{
            return {counter:prevState.counter+1}
        })
    }
    doubleClick(){
        this.setState(prevState =>{
            return {counter:prevState.counter*2}
        })
    }
    render(){
        
        return(
            <div id="counter" className="App-page App-header">
                <h2>{this.state.counter}</h2>
                <button onClick={this.addOneClick}>Add One </button>
                <button onClick= {this.double}>Double</button>
            </div>
        )
    }
}
export default Counter;