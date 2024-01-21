import React from "react";
import { Link } from 'react-router-dom';
import './Header.css'

const Header = () => {
    return(
        <header className="header">
            <div className="logo-container">
                <img src="path-to-your-logo.png" alt="Garage Logo" className="logo" />
                <h1 className="garage-name">BookYourRepair</h1>
            </div>
            <nav className="navigation-menu">
                <ul>
                    <li><Link to="/">Home</Link></li>
                    <li><Link to="/schedule">Schedule</Link></li>
                    <li><Link to="/reports">Reports</Link></li>
                    <li><Link to="/settings">Settings</Link></li>
                </ul>
            </nav>
        </header>
    )
}

export default Header;