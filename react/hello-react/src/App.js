// import './App.css';

// function App() {
//   const name = '리액트';
//   // JavaScript 영역의 주석입니다
//   return (
//     <div className="react">
//       {name}
//       {/* JSX 영역의 주석입니다 */}
//       <input />
//     </div>
//   );
// }

// export default App;

import './App.css';
import React, { Component } from 'react';

class App extends Component {
  render() {
    const name = '리액트';
    return <div className="react">{name}</div>;
  }
}

export default App;
