import React,{Component} from 'react';

class FormData extends Component{
    constructor(){
        super()
        this.state = {
             firstName:"",
             lastName:"",
             age:"",
             gender:"",
             destination:"",
             isVegan:"",
             isKosher:"",
             isLactoseFree:""
        }
        this.handleChange =this.handleChange.bind(this)
    }

    handleChange(event){
        const{name,value,type,checked} = event.target
        type === "checkbox"?
            this.setState({
                [name]:checked
            })
            :
        this.setState({
            [name]:value
        })

    }

    render(){
        return(
            <div id="formdata" >
                <h2>Form Data</h2>
                <input
                    name="firstName"
                    placeholder="First Name"
                    onChange= {this.handleChange}
                /><br />
                <input
                    name="lastName"
                    placeholder="Last Name"
                    onChange= {this.handleChange}
                /><br />
                <input
                    name="age"
                    placeholder="Age"
                    onChange= {this.handleChange}
                /><br />
                <label>
                    <input
                    type="radio"
                    name="gender"
                    value="Male"
                    onChange= {this.handleChange}
                    />Male
                </label><br/>
                <label>
                    <input
                    type="radio"
                    name="gender"
                    value="Female"
                    onChange= {this.handleChange}
                    />Female
                </label><br/>
                <select
                    name="destination"
                    value={this.state.destination}
                    onChange={this.handleChange}
                >
                    <option value ="">--Please choose a destination</option>
                    <option value ="New York,NY" name="newYork">New York,NY</option>
                    <option value="Venice,Italy" name="venice">Venice,Italy</option>
                    <option value="Atlanta,GA" name="atlanta">Atlanta,GA</option>

                </select><br/>
                <input
                    type="checkbox"
                    name="isVegan"
                    checked={this.state.isVegan}
                    onChange={this.handleChange}
                />Vegan?
                
                <hr />
                <h2>Entered Information</h2>
                <h2>Name: {this.state.firstName} {this.state.lastName}</h2>
                <h2>Age: {this.state.age}</h2>
                <h2>Gender: {this.state.gender}</h2>
                <h2>Destination: {this.state.destination}</h2>
                <h2>Vegan? {this.state.isVegan ? "Yes":"No"}</h2>
            </div>
        )
    }
}
export default FormData;