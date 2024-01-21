import logo from './logo.svg';
import './App.css';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Header from './Header'
import Schedule from './Schedule';

const App = () => {
  return (
    <Router>
      <Header />
      <Routes>
        <Route path="/" exact>
          {/* Home component */}
        </Route>
        <Route path="/schedule" element={<Schedule />}>
          {/* Schedule component */}
        </Route>
        <Route path="/reports">
          {/* Reports component */}
        </Route>
        <Route path="/settings">
          {/* Settings component */}
        </Route>
        {/* Add other routes as needed */}
      </Routes>
    </Router>
  );
}

export default App;
