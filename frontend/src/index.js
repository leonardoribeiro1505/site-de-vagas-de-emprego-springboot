import React from 'react';
import ReactDOM from 'react-dom';
import 'antd/dist/antd.css';
import App from './main/App';
//import './index.css';
import registerServiceWorker from './registerServiceWorker';

ReactDOM.render(<App />, document.getElementById('root'));
registerServiceWorker();
