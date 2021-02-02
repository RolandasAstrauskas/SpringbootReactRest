import React, {Component} from 'react';
import axios from 'axios';

import {Table} from 'react-bootstrap';
import {DropdownButton} from 'react-bootstrap';
import {Dropdown} from 'react-bootstrap';
import './QuantityInput.css';

export default class TableDropdown extends Component{

       constructor(props){
             super(props);
             this.state = {
              countryName :[],
              country :[]
              };
              }

       componentDidMount(){
               axios.get("http://localhost:8080/allCountry")
              .then(response => response.data)
              .then((data) => {
              this.setState({countryName: data})
       });
       }

       getCountryHandler = (e) =>{
              this.setState({country: []});
               axios.get("http://localhost:8080/all/%7Bcountry%7D?country=" + e)
              .then(response => response.data)
              .then((data) => {
              this.setState({country: data})
              });

              }

     render(){
         return (
       <div>
         <DropdownButton

           bsStyle="default"
           bsSize="small"
           style={{ maxHeight: "40px" }}
           id="dropdown-basic-button" title="Select country">
                   {this.state.countryName.map((countryName) => (
                      <Dropdown.Item onSelect = {this.getCountryHandler} eventKey = {countryName} value = {countryName}>{countryName}</Dropdown.Item>
                     ))}
         </DropdownButton>

    <Table responsive striped bordered variant="dark">
        <thead >
          <tr>
            <th>Weeks--></th>
            {this.state.country.map((country) => (
              <th key={country.year_week}>{country.year_week}</th>
            ))}
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>Case</td>
            {this.state.country.map((country) => (
              <td key={country.indicatorDeath}>{country.indicatorDeath}</td>
            ))}
          </tr>
          <tr>
            <td>Death</td>
            {this.state.country.map((country) => (
             <td key={country.indicatorCase}>{country.indicatorCase}</td>
             ))}
          </tr>
        </tbody>
      </Table>
    </div>
            );
     }
}
