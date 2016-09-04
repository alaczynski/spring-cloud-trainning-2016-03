# ds
- discovery service, eureka
# config
- config service
# payment
- api
    - /payments returns payment status
# catalog
- dependencies
    - payment
    - config (payment service name)
- api
    - /orders
  