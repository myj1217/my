import React, { Component } from 'react';
import './ValidationSample.css';
class ValidationSample extends Component {
  state = {
    password: '',
    clicked: false,
    validated: false,
  };

  input = React.createRef();
  handleChange = (e) => {
    this.setState({ password: e.target.value });
  };

  haldleButtonClick = () => {
    this.setState({ clicked: true, validated: this.state.password === '0000' });
    this.input.current.focus();
  };
  render() {
    return (
      <div>
        <input
          ref={this.input}
          type="password"
          value={this.state.password}
          onChange={this.handleChange}
          className={
            this.state.clicked
              ? this.state.validated
                ? 'success'
                : 'failure'
              : ''
          }
        />
        <button onClick={this.haldleButtonClick}>검증하기</button>
      </div>
    );
  }
}

export default ValidationSample;
