
##  Bridge Target Complete Event
If the originating call leaves the [&lt;Bridge&gt;](../verbs/bridge.md),
then this callback is sent to the `bridgeTargetCompleteUrl`,
and the BXML returned in it is executed on the target call.

### Expected response
```http
HTTP/1.1 200
Content-Type: application/xml; charset=utf-8

<Response>
    <!-- BXML verbs to process in the target call -->
</Response>
```

### Properties
| Property         | Description |
|:-----------------|:------------|
| eventType        | The event type, value is `bridgeTargetComplete`. |
| eventTime        | The approximate UTC date and time when the event was generated by the Bandwidth server, in ISO 8601 format. This may not be exactly the time of event execution. |
| accountId        | The user account associated with the call. |
| applicationId    | The id of the application associated with the call. |
| from             | The phone number used in the `from` field of the original call, in E.164 format (e.g. +15555555555). |
| to               | The phone number user in the `to` field of the original call, in E.164 format (e.g. +15555555555). |
| direction        | The direction of the call. Either `inbound` or `outbound`. The direction of a call never changes. |
| callId           | The bridge target call id. |
| callUrl          | The URL of the call associated with the event. |
| startTime        | Time the call was started, in ISO 8601 format. |
| answerTime       | Time the call was answered, in ISO 8601 format. |
| tag              | The `tag` specified earlier in the call. If no `tag` was specified or it was previously cleared, this field will not be present. |



#### Example: Bridge completion

```
POST http://[External server URL]
```

```json
{
	"eventType"        : "bridgeTargetComplete",
	"eventTime"        : "2019-07-31T13:16:01.324Z",
	"accountId"        : "55555555",
	"applicationId"    : "7fc9698a-b04a-468b-9e8f-91238c0d0086",
	"from"             : "+15551112222",
	"to"               : "+15553334444",
	"direction"        : "outbound",
	"callId"           : "c-2a913f94-6a486f3a-3cae-4034-bcc3-f0c9fa77ca2f",
	"callUrl"          : "https://voice.bandwidth.com/api/v2/accounts/55555555/calls/c-95ac8d6e-1a31c52e-b38f-4198-93c1-51633ec68f8d",
	"startTime"        : "2019-07-31T13:13:34.859Z",
	"answerTime"       : "2019-07-31T13:13:40.644Z"
}
```

