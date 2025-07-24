
import React, { Component } from 'react';

class Cart extends Component {
  static defaultProps = {
    itemname: "Unknown Item",
    price: 0
  };

  render() {
    const { itemname, price } = this.props;

    return (
      <div style={{ border: "1px solid #ccc", margin: "10px", padding: "10px" }}>
        <p><strong>Item Name:</strong> {itemname}</p>
        <p><strong>Price:</strong> ₹{price}</p>
      </div>
    );
  }
}

export default Cart;
