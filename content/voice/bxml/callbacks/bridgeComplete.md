
##  Bridge Complete Event
If the target call leaves the [&lt;Bridge&gt;](../verbs/bridge.md),
then this callback is sent to the `bridgeCompleteUrl`,
and the BXML returned in it is executed on the call.

This callback is also sent if any problem occurs that prevents the calls to be bridged.

### Expected response
```http
HTTP/1.1 200
Content-Type: application/xml; charset=utf-8

<Response>
    <!-- BXML verbs to process in the call -->
</Response>
```

### Properties
| Property         | Description |
|:-----------------|:------------|
| eventType        | The event type, value is `bridgeComplete`. |
| eventTime        | The approximate UTC date and time when the event was generated by the Bandwidth server, in ISO 8601 format. This may not be exactly the time of event execution. |
| accountId        | The user account associated with the call. |
| applicationId    | The id of the application associated with the call. |
| from             | The phone number used in the `from` field of the original call, in E.164 format (e.g. +15555555555). |
| to               | The phone number user in the `to` field of the original call, in E.164 format (e.g. +15555555555). |
| direction        | The direction of the call. Either `inbound` or `outbound`. The direction of a call never changes. |
| callId           | The call id associated with the event. |
| callUrl          | The URL of the call associated with the event. |
| startTime        | Time the call was started, in ISO 8601 format. |
| answerTime 	   | Time the call was answered, in ISO 8601 format. |
| tag              | The `tag` specified earlier in the call. If no `tag` was specified or it was previously cleared, this field will not be present. |
| cause            | Reason the bridge failed - `busy`, `rejected`, or `unknown`. |
| errorMessage     | Text explaining the reason that caused the bridge to fail in case of errors. |
| errorId          | Bandwidth internal id that references the error event. |



#### Example: Successful bridge completion

```
POST http://[External server URL]
```

```json
{
	"eventType"        : "bridgeComplete",
	"eventTime"        : "2019-07-31T13:15:35.121Z",
	"accountId"        : "55555555",
	"applicationId"    : "7fc9698a-b04a-468b-9e8f-91238c0d0086",
	"from"             : "+15551112222",
	"to"               : "+15553334444",
	"direction"        : "outbound",
	"callId"           : "c-95ac8d6e-1a31c52e-b38f-4198-93c1-51633ec68f8d",
	"callUrl"          : "https://voice.bandwidth.com/api/v2/accounts/55555555/calls/c-95ac8d6e-1a31c52e-b38f-4198-93c1-51633ec68f8d",
	"startTime"        : "2019-07-31T13:13:34.859Z",
	"answerTime"       : "2019-07-31T13:13:40.644Z"
}
```

#### Example: Failed bridge

```
POST http://[External server URL]
```

```json
{
	"eventType"        : "bridgeComplete",
	"eventTime"        : "2019-07-31T13:15:35.121Z",
	"accountId"        : "55555555",
	"applicationId"    : "7fc9698a-b04a-468b-9e8f-91238c0d0086",
	"from"             : "+15551112222",
	"to"               : "+15553334444",
	"direction"        : "outbound",
	"callId"           : "c-95ac8d6e-1a31c52e-b38f-4198-93c1-51633ec68f8d",
	"callUrl"          : "https://voice.bandwidth.com/api/v2/accounts/55555555/calls/c-95ac8d6e-1a31c52e-b38f-4198-93c1-51633ec68f8d",
	"transferCallerId" : "+15551115555",
	"transferTo"       : "+15556667777",
	"startTime"        : "2019-07-31T13:13:34.859Z",
	"answerTime"       : "2019-07-31T13:13:40.644Z",
	"cause"            : "busy",
	"errorMessage"     : "Call c-2a913f94-6a486f3a-3cae-4034-bcc3-f0c9fa77ca2f is already bridged with another call",
	"errorId"          : "4642074b-7b58-478b-96e4-3a60955c6765"
}
```

