mkdir pkg
jar --create --file pkg\model.jar -C out\model .
jar --create --file pkg\service.jar -C out\service .
jar --create --file pkg\client.jar --main-class=com.example.client.Main -C out\client .
