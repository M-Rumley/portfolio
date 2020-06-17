import React,{Component} from 'react';
const API = "/instruments"
class Instruments extends Component{
    constructor(props){
        super(props);
        this.state = {
            data: []
        };
    }
    async componentDidMount(){
        const url = API;
        const response = await fetch(url);
        console.log(response);
        const data = await response.json();
        console.log(data);
        this.setState({instruments:data,loading:false});
    }

    createTableHeaders(){
        return <tr>
            <th>Instrument Id</th>
            <th>Name</th>
            <th>Instrument</th>
            <th>RIC</th>
            <th>International Securities Identification Number(ISIN)</th>
            <th>Stock Exchange Daily Official List(SEDOL)</th>
            <th>Committee on Uniform Securities Identification Procedures(CUSIP)</th>
            <th>BBID</th>
            <th>MIC</th>
            <th>Central Index Key(CIK)</th>
            <th>C.R.U.D</th>
        </tr>
    }

    createTableData(){
        return this.state.instruments.map((myInstrument,index)=>{
            const{name,instrument,ric,isin,sedol,cusip,bbid,mic,cik,id} = myInstrument;
            return(
                <tr key={id}>
                    <td>{id}</td>
                    <td>{name}</td>
                    <td>{instrument}</td>
                    <td>{ric}</td>
                    <td>{isin}</td>
                    <td>{sedol}</td>
                    <td>{cusip}</td>
                    <td>{bbid}</td>
                    <td>{mic}</td>
                    <td>{cik}</td>
                    <td>
                        <button onClick=''>Delete</button>
                        <button onClick=''>Edit</button>
                    </td>
                </tr>
            )
        })
    }
    render(){
        if(this.state.loading){
            return <div>loading...</div>;
        }
        if(!this.state.instruments){
            return <div>Did not find any instruments</div>;
        }
        return(
            <div>
                <table class="table table-striped table-bordered table-hover">
                    <tbody>
                        {this.createTableHeaders()}
                        {this.createTableData()}
                    </tbody>
                </table>
            </div>
        );
    }
}
export default Instruments;