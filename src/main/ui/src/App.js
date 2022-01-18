import logo from './logo.svg';
import './App.css';
import React, { Component } from 'react';

class App extends Component {
  state = {
    isLoading: true,
    groups: [],
    items: []
  };

  async componentDidMount() {
    const databaseResponse = await fetch('/item');
    const databaseBody = await databaseResponse.json();
    console.log("items: "+JSON.stringify(databaseBody[0].content))

    const response = await fetch('/greeting?name=Kris');
    const body = await response.json();

    this.setState({ content: body['content'], isLoading: false, items: databaseBody});
  }

  generateItemsList = (items) => {
    return items.map(function (item) {
      return <div>{item.content}</div>;
    });
  }

  render() {
    const {content, isLoading, items} = this.state;

    if (isLoading) {
      return <p>Loading...</p>;
    }


    return (
        <div className="App">
          <header className="App-header">
            <img src={logo} className="App-logo" alt="logo" />
            <div className="App-intro">
              <h2>JUG List</h2>
              {content}
            </div>
          </header>
          <ul>
            {this.generateItemsList(items)}
          </ul>
        </div>
    );
  }
}

export default App;
