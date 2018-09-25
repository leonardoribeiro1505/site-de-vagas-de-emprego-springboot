import React from 'react';
import ReactDOM from 'react-dom';
import { createStore } from 'redux';
import { Provider } from 'react-redux';

import reducers from './main/reducers'
import './index.css';
import 'antd/dist/antd.css';
import App from './main/App';
import registerServiceWorker from './registerServiceWorker';

const store = createStore(reducers)
ReactDOM.render(
    <Provider store={store}>
        <App />
    </Provider>
, document.getElementById('root'));
registerServiceWorker();
