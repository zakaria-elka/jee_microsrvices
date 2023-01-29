import { Component, OnInit } from '@angular/core';
import {  OAuthService } from 'angular-oauth2-oidc';
import { JwksValidationHandler } from 'angular-oauth2-oidc-jwks';
import { authCodeFlowConfig } from 'src/app/ssoconfig/sso-config';

@Component({
  selector: 'app-side-bar',
  templateUrl: './side-bar.component.html',
  styleUrls: ['./side-bar.component.css']
})
export class SideBarComponent implements OnInit {
  name:string=""

  constructor(private oauthService:OAuthService) { }

  ngOnInit(): void {
    this.configureSingleSignOn();
    const userClaims:any=this.oauthService.getIdentityClaims()
    console.log("here")
     

    console.log(userClaims)
     
    this.name=userClaims.name ? userClaims.name : ""
  }
  configureSingleSignOn(){
    this.oauthService.configure(authCodeFlowConfig)
    this.oauthService.tokenValidationHandler=new JwksValidationHandler()
    this.oauthService.loadDiscoveryDocumentAndTryLogin();

  }
  login(){
    this.oauthService.initCodeFlow()

  }
  logout(){
    this.oauthService.logOut()

  }
  get token(){
    let claims:any=this.oauthService.getIdentityClaims();
    //alert(claims)
    return claims ? claims: null;

  }

}
