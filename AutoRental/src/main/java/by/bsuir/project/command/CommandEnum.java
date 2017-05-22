package by.bsuir.project.command;

import by.bsuir.project.command.impl.*;
import by.bsuir.project.command.impl.bill.*;
import by.bsuir.project.command.impl.brand.*;
import by.bsuir.project.command.impl.car.*;
import by.bsuir.project.command.impl.client.*;
import by.bsuir.project.command.impl.discount.*;
import by.bsuir.project.command.impl.maintenance.*;
import by.bsuir.project.command.impl.order.*;
import by.bsuir.project.command.impl.service.*;
import by.bsuir.project.command.impl.staff.*;
import by.bsuir.project.command.impl.user.*;

public enum CommandEnum {

    TO_LOGIN {
        {
            this.command = new ToLoginCommand();
        }
    },
    TO_REGISTRATION {
        {
            this.command = new ToRegisterCommand();
        }
    },
    LOGIN {
        {
            this.command = new LoginCommand();
        }
    },
    TO_LOGOUT {
        {
            this.command = new LogoutCommand();
        }
    },
    REGISTER {
        {
            this.command = new RegisterCommand();
        }
    },
    VIEW_USERS {
        {
            this.command = new UserList();
        }
    },
    CREATE_USER {
        {
            this.command = new CreateUser();
        }
    },
    UPDATE_USER {
        {
            this.command = new UpdateUser();
        }
    },
    DELETE_USER {
        {
            this.command = new DeleteUser();
        }
    },
    TO_CREATE_USER {
        {
            this.command = new ToCreateUser();
        }
    },
    TO_UPDATE_USER {
        {
            this.command = new ToUpdateUser();
        }
    },
    VIEW_ORDERS {
        {
            this.command = new OrderList();
        }
    },
    CREATE_ORDER {
        {
            this.command = new CreateOrder();
        }
    },
    UPDATE_ORDER {
        {
            this.command = new UpdateOrder();
        }
    },
    DELETE_ORDER {
        {
            this.command = new DeleteOrder();
        }
    },
    TO_CREATE_ORDER {
        {
            this.command = new ToCreateOrder();
        }
    },
    TO_UPDATE_ORDER {
        {
            this.command = new ToUpdateOrder();
        }
    },
    VIEW_SERVICES {
        {
            this.command = new ServiceList();
        }
    },
    CREATE_SERVICE {
        {
            this.command = new CreateService();
        }
    },
    UPDATE_SERVICE {
        {
            this.command = new UpdateService();
        }
    },
    DELETE_SERVICE {
        {
            this.command = new DeleteService();
        }
    },
    TO_CREATE_SERVICE {
        {
            this.command = new ToCreateService();
        }
    },
    TO_UPDATE_SERVICE {
        {
            this.command = new ToUpdateService();
        }
    },
    VIEW_DISCOUNTS {
        {
            this.command = new DiscountList();
        }
    },
    CREATE_DISCOUNT {
        {
            this.command = new CreateDiscount();
        }
    },
    UPDATE_DISCOUNT {
        {
            this.command = new UpdateDiscount();
        }
    },
    DELETE_DISCOUNT {
        {
            this.command = new DeleteDiscount();
        }
    },
    TO_CREATE_DISCOUNT {
        {
            this.command = new ToCreateDiscount();
        }
    },
    TO_UPDATE_DISCOUNT {
        {
            this.command = new ToUpdateDiscount();
        }
    },
    VIEW_BRANDS {
        {
            this.command = new BrandList();
        }
    },
    CREATE_BRAND {
        {
            this.command = new CreateBrand();
        }
    },
    UPDATE_BRAND {
        {
            this.command = new UpdateBrand();
        }
    },
    DELETE_BRAND {
        {
            this.command = new DeleteBrand();
        }
    },
    TO_CREATE_BRAND {
        {
            this.command = new ToCreateBrand();
        }
    },
    TO_UPDATE_BRAND {
        {
            this.command = new ToUpdateBrand();
        }
    },
    VIEW_CARS {
        {
            this.command = new CarList();
        }
    },
    CREATE_CAR {
        {
            this.command = new CreateCar();
        }
    },
    UPDATE_CAR {
        {
            this.command = new UpdateCar();
        }
    },
    DELETE_CAR {
        {
            this.command = new DeleteCar();
        }
    },
    TO_CREATE_CAR {
        {
            this.command = new ToCreateCar();
        }
    },
    TO_UPDATE_CAR {
        {
            this.command = new ToUpdateCar();
        }
    },
    VIEW_BILLS {
        {
            this.command = new BillList();
        }
    },
    CREATE_BILL {
        {
            this.command = new CreateBill();
        }
    },
    UPDATE_BILL {
        {
            this.command = new UpdateBill();
        }
    },
    DELETE_BILL {
        {
            this.command = new DeleteBill();
        }
    },
    TO_CREATE_BILL {
        {
            this.command = new ToCreateBill();
        }
    },
    TO_UPDATE_BILL {
        {
            this.command = new ToUpdateBill();
        }
    },
    VIEW_STAFF {
        {
            this.command = new StaffList();
        }
    },
    CREATE_STAFF {
        {
            this.command = new CreateStaff();
        }
    },
    UPDATE_STAFF {
        {
            this.command = new UpdateStaff();
        }
    },
    DELETE_STAFF {
        {
            this.command = new DeleteStaff();
        }
    },
    TO_CREATE_STAFF {
        {
            this.command = new ToCreateStaff();
        }
    },
    TO_UPDATE_STAFF  {
        {
            this.command = new ToUpdateStaff();
        }
    },
    VIEW_MAINTENANCES {
        {
            this.command = new MaintenanceList();
        }
    },
    CREATE_MAINTENANCE {
        {
            this.command = new CreateMaintenance();
        }
    },
    UPDATE_MAINTENANCE {
        {
            this.command = new UpdateMaintenance();
        }
    },
    DELETE_MAINTENANCE {
        {
            this.command = new DeleteMaintenance();
        }
    },
    TO_CREATE_MAINTENANCE {
        {
            this.command = new ToCreateMaintenance();
        }
    },
    TO_UPDATE_MAINTENANCE  {
        {
            this.command = new ToUpdateMaintenance();
        }
    },
    VIEW_CLIENTS {
        {
            this.command = new ClientList();
        }
    },
    CREATE_CLIENT {
        {
            this.command = new CreateClient();
        }
    },
    UPDATE_CLIENT {
        {
            this.command = new UpdateClient();
        }
    },
    DELETE_CLIENT {
        {
            this.command = new DeleteClient();
        }
    },
    TO_CREATE_CLIENT {
        {
            this.command = new ToCreateClient();
        }
    },
    TO_UPDATE_CLIENT {
        {
            this.command = new ToUpdateClient();
        }
    };
    ActionCommand command;

    public ActionCommand getCommand() {
        return command;
    }
}
