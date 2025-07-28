
import React, { Component } from 'react';

class CurrencyConvertor extends Component {
  constructor(props) {
    super(props);
    this.state = {
      rupees: '',
      euro: ''
    };
  }

  handleChange = (event) => {
    this.setState({ rupees: event.target.value });
  };

  handleSubmit = () => {
    const euroRate = 0.011; // Approximate conversion
    this.setState({ euro: (this.state.rupees * euroRate).toFixed(2) });
  };

  render() {
    return (
      <div>
        <h3>Currency Convertor (INR to EURO)</h3>
        <input
          type="number"
          placeholder="Enter amount in INR"
          value={this.state.rupees}
          onChange={this.handleChange}
        />
        <button onClick={this.handleSubmit} style={{ marginLeft: "10px" }}>Convert</button>
        <p>Euro: €{this.state.euro}</p>
      </div>
    );
  }
}

export default CurrencyConvertor;
