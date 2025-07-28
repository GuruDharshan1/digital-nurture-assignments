
import React, { Component } from 'react';
import CurrencyConvertor from './CurrencyConvertor';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      count: 0
    };
  }

  increment = () => {
    this.setState(prev => ({ count: prev.count + 1 }));
    this.sayHello();
  };

  decrement = () => {
    this.setState(prev => ({ count: prev.count - 1 }));
  };

  sayHello = () => {
    alert("Hello! You clicked the increment button.");
  };

  sayWelcome = (message) => {
    alert(message);
  };

  handlePress = () => {
    alert("I was clicked");
  };

  render() {
    return (
      <div style={{ padding: "20px", fontFamily: "Arial" }}>
        <h2>React Event Examples</h2>
        <p><strong>Counter:</strong> {this.state.count}</p>
        <button onClick={this.increment}>Increment</button>
        <button onClick={this.decrement} style={{ marginLeft: "10px" }}>Decrement</button>
        <br /><br />
        <button onClick={() => this.sayWelcome("Welcome!")}>Say Welcome</button>
        <br /><br />
        <button onClick={this.handlePress}>OnPress</button>
        <br /><br />
        <CurrencyConvertor />
      </div>
    );
  }
}

export default App;
