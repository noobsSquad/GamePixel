import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController} from '@angular/common/http/testing'
import { AuthService } from './auth.service';
import { HttpClient } from '@angular/common/http';
import { LocalStorageService } from 'ngx-webstorage';
import { LoginRequestPayload } from '../login/login-request.payload';
import { Observable, of } from 'rxjs';




// describe('AuthService', () => {
//   let service: AuthService;

//   beforeEach(() => {
//     TestBed.configureTestingModule({});
//     service = TestBed.inject(AuthService);
//   });

//   it('should be created', () => {
//     expect(service).toBeTruthy();
//   });
// });
//   expect(isError).toBe(false);
//   const req = httpTestingController.expectOne('http://localhost:8080/api/auth/login');
//   expect(req.request.method).toEqual('POST');
//   expect(req.request.url).toBe('http://localhost:8080/api/auth/login');
//   req.flush(request);
// });
// });

describe('AuthService', () =>{
  let httpClient: HttpClient;
  let httpTestingController: HttpTestingController;
  let authService: AuthService;
  let localStorage: LocalStorageService;
  beforeEach(()=>{
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers : [
        AuthService, LocalStorageService
      ]
    });
    // Inject the Http controller and service under-test
    httpClient = TestBed.inject(HttpClient);
    httpTestingController = TestBed.inject(HttpTestingController);
    // authService = TestBed.inject(AuthService);
  });

  afterEach(() =>{
    // assert that there are no more pending requests.
    httpTestingController.verify();
  });


  fdescribe('#loginAuthService',() =>{
    const makeURL = "http://localhost:8080/api/auth/login";
    let expectedvalue: boolean;
    let localStorage: LocalStorageService;
    const request: LoginRequestPayload = {username:"testUser",password:"testpassword"};
    it(`should perform a post to ${makeURL}`, () => {
      const httpClientStub: jasmine.SpyObj<HttpClient> = jasmine.createSpyObj('http',['post']);
      const authService = new AuthService(httpClientStub,localStorage);

      httpClientStub.post.and.returnValue(of());
      authService.login(request);
      expect(httpClientStub.post).toHaveBeenCalledWith(makeURL,request);
      expect(httpClientStub.post).toBeTruthy;

    });
    //TEST 404 Error
    //TEST 
    
 
    
    // it('should return value true, if the user logged in correctly', ()=>{
      
    //   authService.login(request).subscribe(data =>{
    //     // expect(data).toEqual(request, 'should return true value for login');
    //   });
    //   const req = httpTestingController.expectOne(makeURL);
    //   expect(req.request.method).toEqual('POST', 'request should be POST');
    //   // expect(req.request.body).toEqual(true);
    //   expect(req.request.url).toEqual(makeURL, 'URL SHOULD BE API ENDPOINT');
    // })
  });

});