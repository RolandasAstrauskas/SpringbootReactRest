import React, {Component} from 'react';

import {Navbar, Container, Col} from 'react-bootstrap';


export default class Footer extends Component{
     render(){
         return (
         <Navbar fixed="bottom" bg="dark" variant="dark">
             <Container>
                   <Col lg={12} className="text-center text-muted">
                     <div>Covid-19 Statistic By Country</div>
                   </Col>
             </Container>
         </Navbar>
         );
     }
}
