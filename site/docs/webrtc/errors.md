---
id: errors
title: Errors
slug: /webrtc/errors
description: WebRTC Errors
keywords:
  - bandwidth
  - webrtc
  - video
hide_title: true
image: ../../static/img/bandwidth-logo.png
---
Categorized error codes generated by the application.
  * 401 - Unauthorized
  * 403 - Access Denied
  * 404 - Not Found
  * 500 - Internal Server Error

### 401 – Unauthorized

Bandwidth will return a HTTP-401 Error when the specified user does not have access to the account. Ensure the username and password are correct along with the correct account number.

### 403 – FORBIDDEN

Bandwidth returns a HTTP-403 error when the user does not have access to WebRTC APIs.

### 404 – NOT_FOUND

Bandwidth returns a HTTP-404 when a resource is not found or no longer active. This can include sessions and participants.

### 500 – Internal Server Error

Bandwidth will return a HTTP-500 Error when an unknown error occurs. If you receive a HTTP-500 error, please open a [support ticket](https://support.bandwidth.com/hc/en-us) with the original request and the response returned. Please be sure to remove any passwords or sensitive information!