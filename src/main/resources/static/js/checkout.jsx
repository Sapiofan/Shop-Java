const e = React.createElement;

class Checkout extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            data:false,
            cardInput:false,

            name:"",
            phone:"",
            email:"",
            city:"",

            card:"",
            date:"",
            cvv:"",

            areaCode: "",
            prefix: "",
            suffix: ""
        };

        this.handleInputChange = this.handleInputChange.bind(this);
        this.handleCard = this.handleCard.bind(this);
        this.handleData = this.handleData.bind(this);
        this.setInputRef = this.setInputRef.bind(this);
        this.handleChange = this.handleChange.bind(this);
    }

    handleInputChange(event) {
        const target = event.target;
        const value =  target.value;
        const name = target.name;

        this.setState({
            [name]: value
        });
    }

    handleCard() {
        this.setState({data:true})
    }

    handleData() {
        this.setState({cardInput:true})
    }

    setInputRef(name, element) {
        this[name] = element;
    }

    handleChange({ target: { name, value } }) {
        let valueChanged = false;
        this.setState(prevState => {
            const nextValue = value.replace(/[^\d]/g, '');
            const changedValue = prevState[name];
            if (changedValue.length !== nextValue.length) valueChanged = true;

            return { [name]: nextValue }
        }, () => {
            if(valueChanged) this.handleFocus(name)
        });
    };

    handleFocus(name){
        const { areaCode, prefix, suffix } = this.state;
        const areaCodeFilled = areaCode.length === 3;
        const prefixFilled = prefix.length === 2;

        if(areaCodeFilled && name === "areaCode") {
            this.prefix.focus();
            this.prefix.selectionEnd = 0;
        } else if(prefixFilled && name === "prefix") {
            this.suffix.focus();
            this.suffix.selectionEnd = 0;
        }
    }

    render() {
        if(this.state.cardInput){
            window.location.href="home.html"
        }
        else if (this.state.data) {
            return (
                <form className="data-form" >
                    <h1>Credit card</h1>
                    {/* <div className="text-container">
                <p>Card number</p>
                <input
                onChange={this.handleInputChange}
                name="card" type={"text"}
                className="text-field"
                value={this.state.card}
                placeholder="xxxx-xxxx-xxxx-xxxx"></input>
            </div> */}
                    <div className="input-card">
                        <input
                            ref={node => this.setInputRef("suffix", node)}
                            className="input suffix"
                            type="text"
                            name="suffix"
                            placeholder="xxxx"
                            value={this.state.suffix}
                            onChange={this.handleChange}
                            maxLength="4"
                        />
                        <div className="dash">-</div>
                        <input
                            ref={node => this.setInputRef("suffix", node)}
                            className="input suffix"
                            type="text"
                            name="suffix"
                            placeholder="xxxx"
                            value={this.state.suffix}
                            onChange={this.handleChange}
                            maxLength="4"
                        />
                        <div className="dash">-</div>
                        <input
                            ref={node => this.setInputRef("suffix", node)}
                            className="input suffix"
                            type="text"
                            name="suffix"
                            placeholder="xxxx"
                            value={this.state.suffix}
                            onChange={this.handleChange}
                            maxLength="4"
                        />
                        <div className="dash">-</div>
                        <input
                            ref={node => this.setInputRef("suffix", node)}
                            className="input suffix"
                            type="text"
                            name="suffix"
                            placeholder="xxxx"
                            value={this.state.suffix}
                            onChange={this.handleChange}
                            maxLength="4"
                        />
                    </div>
                    {/* <div className="text-container">
                <p>Expiry date</p>
                <input
                onChange={this.handleInputChange}
                name="date" type={"text"}
                className="text-field"
                value={this.state.date}
                placeholder="mm/yyyy"></input>
            </div> */}
                    <div className="input-phone">
                        <input
                            ref={node => this.setInputRef("prefix", node)}
                            className="input prefix"
                            type="text"
                            name="prefix"
                            placeholder="mm"
                            value={this.state.prefix}
                            onChange={this.handleChange}
                            maxLength="2"
                        />
                        <div className="dash">/</div>
                        <input
                            ref={node => this.setInputRef("suffix", node)}
                            className="input suffix"
                            type="text"
                            name="suffix"
                            placeholder="yyyy"
                            value={this.state.suffix}
                            onChange={this.handleChange}
                            maxLength="4"
                        />
                    </div>
                    <div className="text-container">
                        <p>Security code</p>
                        <input
                            onChange={this.handleInputChange}
                            name="cvv" type={"text"}
                            className="text-field"
                            value={this.state.cvv}
                            placeholder="xxx"></input>
                    </div>
                    <input onClick={this.handleData} disabled={!this.state.card, !this.state.date, !this.state.cvv}
                           className="submit" value="Pay" />
                </form>
            )
        }
        else{
            return (
                <form className="data-form">
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
                    <input onClick={this.handleCard}
                           type="submit" className="submit" value="Next" />
                </form>
            )
        }
    }
}

const domContainer = document.querySelector('#checkout-form');
ReactDOM.render(e(Checkout), domContainer);

// disabled={!this.state.name, !this.state.phone, !this.state.email, !this.state.city}

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