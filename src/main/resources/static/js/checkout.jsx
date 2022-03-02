const e = React.createElement;

class Checkout extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            name:"",
            phone:"",
            email:"",
            city:"",

            card:"",
            date:"",
            cvv:""

        };

        this.handleInputChange = this.handleInputChange.bind(this);
    }

    handleInputChange(event) {
        const target = event.target;
        const value =  target.value;
        const name = target.name;

        this.setState({
            [name]: value
        });
    }

    render() {
        if (this.state.personal) {
            return 'You liked this.';
        }

        return (
            <form className="personal-data-form">
                <div className="text-container">
                    <p>Name</p>
                    <input
                        onChange={this.handleInputChange}
                        name="name" type={"text"}
                        className="text-field"
                        value={this.state.name}
                        placeholder="Your name"></input>
                </div>
                <div className="text-container">
                    <p>Phone</p>
                    <input
                        onChange={this.handleInputChange}
                        name="phone" type={"text"}
                        className="text-field"
                        value={this.state.phone}
                        placeholder="Input contact phone"></input>
                </div>
                <div className="text-container">
                    <p>Email</p>
                    <input
                        onChange={this.handleInputChange}
                        name="email" type={"email"}
                        className="text-field"
                        value={this.state.email}
                        placeholder="Input email"></input>
                </div>
                <div className="text-container">
                    <p>City</p>
                    <input
                        onChange={this.handleInputChange}
                        name="city" type={"text"}
                        className="text-field"
                        value={this.state.city}
                        placeholder="Input city"></input>
                </div>
                <input type="submit" className="submit" value="Submit" />
            </form>
        )
    }
}

const domContainer = document.querySelector('#checkout-form');
ReactDOM.render(e(Checkout), domContainer);

// import "./checkout.css";

// const e = React.createElement;

// class Checkout extends React.Component {
//   constructor(props) {
//     super(props);
//     this.state = { personal: false };
//   }

//   render() {
//     if (this.state.personal) {
//       return 'You liked this.';
//     }


//     let className = 'menu';
//     if (this.props.isActive) {
//         className += ' menu-active';
//     }
//     return <span className={className}>Menu</span>

//   }
// }

// const domContainer = document.querySelector('#checkout-form');
// ReactDOM.render(e(Checkout), domContainer);