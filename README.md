Symmetric Key Encryption steps
======================================

1. Download latest version of JCE .
2. Take backup of local_policy.jar and US_export_policy.jar from C:\jdk1.8.0_111\jre\lib\security
3. Add bootstrap.properties in ConfigServer project and below lines:
   encrypt.key=ABCDEFGHIJKLMNOPQRSTUVWXYZ

4. Use postman to "POST" the below payload to localhost:8888/encrypt
   Payload ::
   connectionstring=server123;user=root;password=pass@word1

5. The response is the encrypted string::
   
   b3c9477319fbc4b534ccfb4835c14dc5b5315105b972f7ba7aac01b21482dc2b5a491e746bf4b621f7fc5b70833198d9c1aa10351a94e12818c98d91b429b19d1ac6e4c6df9c78f5cdee7dae4fa5acfd
   
6. To chck decrypt is working POST below payload to   localhost:8888/decrypt

   b3c9477319fbc4b534ccfb4835c14dc5b5315105b972f7ba7aac01b21482dc2b5a491e746bf4b621f7fc5b70833198d9c1aa10351a94e12818c98d91b429b19d1ac6e4c6df9c78f5cdee7dae4fa5acfd
   
7. Add below property in application.properties in github project :: https://github.com/ruplim/cloud-config-chi-tolls

  connstring={cipher}b3c9477319fbc4b534ccfb4835c14dc5b5315105b972f7ba7aac01b21482dc2b5a491e746bf4b621f7fc5b70833198d9c1aa10351a94e12818c98d91b429b19d1ac6e4c6df9c78f5cdee7dae4fa5acfd

8. Now hit the url : localhost:8888/s1rates/dev .. the response will display the data in decrypted format as the server is able to decrypt it.

9. Update RateController to add connstring

10. test with url :  http://localhost:8080/rate.  The ConfigServer returns the decrypted string

11. To disable decryption in the Config Server; add below lines in application.yml in ConfigServer
    encrypt:
          enabled: false
          
12. now hit the url in postman to confirm - localhost:8888/s1rates/dev

13. Add encrypt.key=ABCDEFGHIJKLMNOPQRSTUVWXYZ in bootstrap.properties of ConfigClient code.

14, test with url :  http://localhost:8080/rate to confirm decrypted data
