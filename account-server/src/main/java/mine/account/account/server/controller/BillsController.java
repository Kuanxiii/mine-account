package mine.account.account.server.controller;

import mine.account.account.server.dto.AccountDTO;
import mine.account.account.server.dto.RequestDTO;
import mine.account.account.server.dto.ResponseDTO;
import mine.account.account.server.service.BillsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@ResponseBody
@RestController
@RequestMapping("/bills")
public class BillsController {


    @Resource
    private BillsService billsService;

    @PostMapping("add")
    public ResponseDTO<Object> add(@RequestBody RequestDTO<AccountDTO> accountDTO){
        billsService.addAccount(accountDTO.getData());
        return new ResponseDTO<>();
    }

    @PostMapping("batch_add")
    public ResponseDTO<Object> batchAdd(@RequestBody RequestDTO<List<AccountDTO>> accountDTOs){
        billsService.batchAddAccount(accountDTOs.getData());
        return new ResponseDTO<>();
    }

    @GetMapping("test")
    public ResponseDTO<AccountDTO> getAll(){
        ResponseDTO<AccountDTO> responseDTO = new ResponseDTO<>();
        responseDTO.setData(new AccountDTO());
        return responseDTO;
    }

}
