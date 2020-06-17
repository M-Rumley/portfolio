import React,{Component} from 'react';
import "../styles/tables.css"
const API = "/orders"
class Orders extends Component{
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
        this.setState({orders:data,loading:false});
    }

    createTableHeaders(){
        return <tr>
            <th>Orders Id</th>
            <th>Client Id</th>
            <th>C. Qty</th>
            <th>Leaves Qty</th>
            <th>Msg Type</th>
            <th>Status</th>
            <th>Order Type</th>
            <th>Date Time</th>
            <th>Order Id</th>
            <th>Instrument</th>
            <th>Order Qty</th>
            <th>Desc</th>
            <th>Parent Order Id</th>
            <th>Price</th>
            <th>Root Order Id</th>
            <th>Side</th>
            <th>System Id</th>
            <th>Venue</th>
            <th>C.R.U.D</th>
        </tr>
    }

    createTableData(){
        return this.state.orders.map((myOrder,index)=>{
            const{datetimestamp,clientid,rootordid,parentordid,msgtype,orderid,systemid,
                instrument,ordstatus,ordtype,venue,side,orderqty,cumqty,leavesqty,price,descr,id} = myOrder;
            return(
                <tr key={id}>
                    <td>{id}</td>
                    <td>{clientid}</td>
                    <td>{cumqty}</td>
                    <td>{leavesqty}</td>
                    <td>{msgtype}</td>
                    <td>{ordstatus}</td>
                    <td>{ordtype}</td>
                    <td>{datetimestamp}</td>
                    <td>{orderid}</td>
                    <td>{instrument}</td>
                    <td>{orderqty}</td>
                    <td>{descr}</td>
                    <td>{parentordid}</td>
                    <td>{price}</td>
                    <td>{rootordid}</td>
                    <td>{side}</td>
                    <td>{systemid}</td>
                    <td>{venue}</td>
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
        if(!this.state.orders){
            return <div>Did not get any orders</div>;
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
export default Orders;