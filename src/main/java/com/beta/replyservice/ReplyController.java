package com.beta.replyservice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class ReplyController {

	@GetMapping("/reply")
	public ReplyMessage replying() {
		ReplyMessage reply = new ReplyMessage("Message is empty");
		return reply;
	}

	@GetMapping("/reply/{message}")
	public ReplyMessage replying(@PathVariable String message) {
		ReplyMessage reply = new ReplyMessage(message);
		/*if(reply.getMessage()!=null && reply.getMessage().startsWith("Invalid")) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Invalid input.");
		}
		else {*/
			return reply;
		//}
	}
}