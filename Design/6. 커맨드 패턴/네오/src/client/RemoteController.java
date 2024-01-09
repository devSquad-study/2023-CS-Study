package client;

import command.IotCommand;

public interface RemoteController {

    void setButton01(int slot, IotCommand command);
    void setButton02(int slot, IotCommand command);
    void setButton03(int slot, IotCommand command);
    void button01(int slot);
    void button02(int slot);
    void button03(int slot);
    void undo();

}
